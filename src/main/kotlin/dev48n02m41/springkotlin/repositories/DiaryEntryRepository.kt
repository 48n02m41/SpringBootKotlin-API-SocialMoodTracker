package dev48n02m41.springkotlin.repositories

import dev48n02m41.springkotlin.entities.DiaryEntryEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
//@Transactional(Transactional.TxType.MANDATORY)
interface DiaryEntryRepository : JpaRepository<DiaryEntryEntity, Long>