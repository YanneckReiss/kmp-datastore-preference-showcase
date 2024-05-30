import com.yanneckreiss.kmpapp.data.KeyValueStore
import com.yanneckreiss.kmpapp.domain.IncrementAppOpeningCounterUseCase
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.coEvery
import io.mockative.coVerify
import io.mockative.mock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class IncrementAppOpeningCounterUseCaseTest {

    @Mock
    private val keyValueStore = mock(classOf<KeyValueStore>())

    private val useCase = IncrementAppOpeningCounterUseCase(keyValueStore)

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `App opening counter gets correctly incremented`() = runTest {

        // Arrange
        val testCounter = 1
        coEvery { keyValueStore.getAppOpeningCounter() }.returns(testCounter)

        // Act
        useCase.call()

        // Assert
        coVerify { keyValueStore.saveAppOpeningCounter(testCounter + 1) }.wasInvoked(1)
    }
}
