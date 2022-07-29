package com.example.fxgui2p2

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

/*要素
        * 1.打jar包用插件命令，为了把依赖打进去
        * 2.当前命令行intstall jar，并且在pox.xml中添加依赖,为了申明jar包信息
        * 3.先clean后在compile，缓存会有影响
        * */

/*要素
        * 1.打jar包用插件命令，为了把依赖打进去
        * 2.当前命令行intstall jar，并且在pox.xml中添加依赖,为了申明jar包信息
        * 3.先clean后在compile，缓存会有影响
        * */
//MulThreadUtil.splitPdf("D:\\360MoveData\\Users\\28442\\Desktop\\1.pdf")
class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

 fun starta() {
    Application.launch(HelloApplication::class.java)
}