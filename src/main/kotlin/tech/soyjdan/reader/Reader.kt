package tech.soyjdan.reader

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory


class Reader {

    fun read(file: File): Unit {

        try {

            val bdf = DocumentBuilderFactory.newInstance()
            val db = bdf.newDocumentBuilder()
            val doc: Document = db.parse(file)

            val nodeList: NodeList = doc.childNodes

            iteratorRead(nodeList)

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    private fun iteratorRead(nodeList: NodeList, indentLevel: Int = 0): Unit {
        val indent = "\t".repeat(indentLevel)

        for (i in 0 until nodeList.length) {
            val node: Node = nodeList.item(i)

            when (node.nodeType) {
                Node.ELEMENT_NODE -> {
                    if (!node.nodeName.contains("#text")) {
                        val element: Element = node as Element

                        addMessage(
                            indent + element.nodeName + ": "
                        )

                        if (node.hasChildNodes()) {
                            val nodeList1: NodeList = node.getChildNodes()
                            iteratorRead(nodeList1, indentLevel + 1)
                        }
                    }
                }

                Node.TEXT_NODE -> {
                    addMessage(indent + node.textContent.trim())
                }

                Node.COMMENT_NODE -> {
                    addMessage(indent + "<!-- " + node.textContent.trim() + " -->")
                }
            }
        }
    }

    private fun addMessage(message: String): Unit {

        println(message)
    }
}