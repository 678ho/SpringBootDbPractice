package org.zerock.ez2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ez2.entity.Memo;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
}

/*
* 작성된 MemoRepository는 특이하게도 인터페이스 자체이고 JpaRepository를 상속하는 것만으로 모든 작업이 끝난다.
* */
