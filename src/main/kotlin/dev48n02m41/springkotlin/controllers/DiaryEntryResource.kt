package dev48n02m41.springkotlin.controllers

import dev48n02m41.springkotlin.entities.DiaryEntryEntity
import dev48n02m41.springkotlin.services.DiaryEntryService
import net.minidev.json.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*


@RestController
@RequestMapping(path = ["/v1/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
@CrossOrigin(origins = ["*"])
class DiaryEntryResource (private val service: DiaryEntryService) {

    @GetMapping("/public/test", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun testGET(): ResponseEntity<Any?>? {
        return ResponseEntity.status(HttpStatus.OK).body(
            Collections.singletonMap("status", "up")
        )
    }

    @GetMapping("/private")
    fun getTasks(): List<DiaryEntryEntity> = service.getAll()

    @PostMapping("/private")
    fun addOne(@Validated @RequestBody entry: DiaryEntryEntity): ResponseEntity<DiaryEntryEntity> =
            service.addOne(entry)

    @GetMapping("/private/{id}")
    fun getOneById(@PathVariable(value = "id") idIn: Long): ResponseEntity<DiaryEntryEntity> =
            service.getById(idIn)

//    @DeleteMapping("/{id}")
//    fun deleteOne(@PathVariable(value = "id") idIn: Long): ResponseEntity<Void> =
//            service.deleteOne(idIn)

}

