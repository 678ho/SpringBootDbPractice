package org.zerock.ez2.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.zerock.ez2.entity.Memo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample...."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect() {
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("====================================================================");

        if(result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }

    }
    @Test
    public void testUpdate() {
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void testDelete() {
        Long mno = 100L;

        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault() {
        Pageable pageable = PageRequest.of(0,10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total Pages : "+result.getTotalPages()); // 페이지 수
        System.out.println("Total Count : "+result.getTotalElements()); // 전체 갯수
        System.out.println("Page Number : "+result.getNumber()); // 전체 페이지 번호 ( 0부터 시작 )
        System.out.println("Page Size : "+result.getSize()); // 페이지당 데이터 갯수
        System.out.println("has next page? : "+result.hasNext()); // 다음 페이지 존재 여부 확인
        System.out.println("first page? : "+result.isFirst()); // 첫페이지인지 여부 확인
        System.out.println("---------------------------------------------------------------");
        for (Memo memo : result.getContent()) {
            System.out.println(memo);
        }
    }
}
