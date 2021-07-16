package org.zerock.ez2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ez2.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}

/*
* 작성된 MemoRepository는 특이하게도 인터페이스 자체이고 JpaRepository를 상속하는 것만으로 모든 작업이 끝난다.
* */
