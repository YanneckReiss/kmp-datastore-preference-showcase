//
//  MainScreen.swift
//  iosApp
//
//  Created by Yanneck Reiß on 18.05.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    var body: some View {
        NavigationView {
            VStack {
                Spacer()
                Text("Hello")
                    .font(.largeTitle)
                    .fontWeight(.bold)
                Spacer()
            }
            .toolbar {
                ToolbarItem(placement: .principal) {
                    Text("Toolbar")
                        .font(.headline)
                }
            }
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
