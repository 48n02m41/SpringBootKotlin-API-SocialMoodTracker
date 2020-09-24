package dev48n02m41.springkotlin.controllers

import dev48n02m41.springkotlin.entities.DiaryEntryEntity
import dev48n02m41.springkotlin.services.DiaryEntryService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/data")
class DiaryEntryResource (private val service: DiaryEntryService) {

    @GetMapping
    fun getTasks(): List<DiaryEntryEntity> = service.getAll()

    @PostMapping
    fun addOne(@Validated @RequestBody entry: DiaryEntryEntity): ResponseEntity<DiaryEntryEntity> =
            service.addOne(entry)

    @GetMapping("/{id}")
    fun getOneById(@PathVariable(value = "id") idIn: Long): ResponseEntity<DiaryEntryEntity> =
            service.getById(idIn)

    @DeleteMapping("/{id}")
    fun deleteOne(@PathVariable(value = "id") idIn: Long): ResponseEntity<Void> =
            service.deleteOne(idIn)

}

