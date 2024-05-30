//
//  MainScreen.swift
//  iosApp
//
//  Created by Yanneck Reiß on 18.05.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import Shared

struct MainScreen: View {
    
    @State private var counter: Int = 0
    
    var body: some View {
         NavigationView {
             VStack(
                 alignment: .center,
                 spacing: 10
             ) {
                 Text("Counter")
                     .font(.system(size: 20))
                 Text("\(counter)")
                     .font(.system(size: 40))
             }
             .frame(maxWidth: .infinity, maxHeight: .infinity)
             .toolbar {
                 ToolbarItem(placement: .principal) {
                     Text("Toolbar")
                         .font(.headline)
                 }
             }
             .navigationBarTitleDisplayMode(.inline)
             .onAppear {
                 fetchAppOpening()
             }
         }
     }
    
    private func fetchAppOpening() {
        DispatchQueue.main.async {
            Task {
                if let newCounter = try? await KoinDependencies().getAppOpeningCountUseCase.call() {
                    DispatchQueue.main.async {
                        self.counter = Int(newCounter.intValue)
                    }
                } else {
                    DispatchQueue.main.async {
                        self.counter = 0 // or any default value
                    }
                }
            }
        }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
