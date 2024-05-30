import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        KoinKt.doInitKoin()
        
        trackAppOpening()
    }
    
    var body: some Scene {
        WindowGroup {
            MainScreen()            
        }
    }
    
    private func trackAppOpening() {
        DispatchQueue.main.async {
            Task {
                try? await KoinDependencies().incrementAppOpeningCounterUseCase.call()
            }
        }
    }
}
