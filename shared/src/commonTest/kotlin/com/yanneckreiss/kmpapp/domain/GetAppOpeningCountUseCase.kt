package com.yanneckreiss.kmpapp.domain

import com.yanneckreiss.kmpapp.data.KeyValueStore
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.coEvery
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
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetAppOpeningCountUseCaseTest {

    @Mock
    private val keyValueStore = mock(classOf<KeyValueStore>())

    private val useCase = GetAppOpeningCountUseCase(keyValueStore)

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Stored app opening counter gets correctly returned`() = runTest{

        // Arrange
        val testCounter = 5
        coEvery { keyValueStore.getAppOpeningCounter() }.returns(testCounter)

        // Act
        val result: Int = useCase.call()

        // Assert
        assertTrue { result == testCounter }
    }
}
