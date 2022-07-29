package com.example.fxgui2p2


import com.example.pdfsplit.pdfdeal.MulThreadUtil
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField

class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private lateinit var inp: TextField

    @FXML

    private lateinit var outp: TextArea

    @FXML
    private fun onHelloButtonClick() {
        var text = inp.text
        var inputFullPath = text
        MulThreadUtil.splitPdf(inputFullPath)
        println("text: $text")
        outp.text = "处理： $text 任务完成"
        welcomeText.text = "PDF文件多线程切图0.0.1"
    }


}