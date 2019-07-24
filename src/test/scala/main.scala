package main

import java.util.concurrent.atomic.AtomicInteger
import  io.undertow._
import server.{HttpServerExchange, HttpHandler}
import util.Headers

object Rest extends App {


  override def main(args: Array[String]): Unit = {
    val counter = new AtomicInteger(0)
    val server = Undertow.builder.addListener(8082, "localhost").setHandler(
      new HttpHandler() {
        @throws[Exception]
        def handleRequest(exchange: HttpServerExchange): Unit = {

          exchange.getResponseHeaders.put(Headers.CONTENT_TYPE, "text/plain")
          val cnt =counter.incrementAndGet
          println(cnt)
          exchange.getResponseSender.send(cnt.toString)
        }
      }).build
    server.start
  }
}