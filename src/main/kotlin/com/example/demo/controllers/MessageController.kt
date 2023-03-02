package com.example.demo.controllers

import com.example.demo.services.Message
import com.example.demo.services.MessageService
import org.springframework.web.bind.annotation.*


@RestController
class MessageController(val service: MessageService) {

    @GetMapping("/")
    fun index(): List<Message> = service.findMessages()

    @PostMapping("/")
    fun post(@RequestBody message: Message): String {
        service.save(message)
        return "ok\n"
    }

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<Message> =
        service.findMessageById(id)
}


