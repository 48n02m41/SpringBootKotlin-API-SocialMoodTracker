package dev48n02m41.springkotlin.services

import dev48n02m41.springkotlin.entities.DiaryEntryEntity
import dev48n02m41.springkotlin.repositories.DiaryEntryRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DiaryEntryService(private val diaryEntryRepository: DiaryEntryRepository) {

    fun getAll(): List<DiaryEntryEntity> = diaryEntryRepository.findAll()

    fun addOne(diaryEntry: DiaryEntryEntity): ResponseEntity<DiaryEntryEntity> =
            ResponseEntity.ok(diaryEntryRepository.save(diaryEntry))

    fun getById(idIn: Long): ResponseEntity<DiaryEntryEntity> =
            diaryEntryRepository.findById(idIn).map { result ->
                ResponseEntity.ok(result)
            }.orElse(ResponseEntity.notFound().build())

    fun deleteOne(idIn: Long): ResponseEntity<Void> =
            diaryEntryRepository.findById(idIn).map { result ->
                diaryEntryRepository.delete(result)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())
}