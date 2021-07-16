package org.zerock.ez2.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 해당 클래스가 엔티티를 위한 클래스이며, 해당 클래스의 인스턴스들이 JPA로 관리되는 엔티티 객체라는 것을 의미.
@Table(name= "tbl_memo") // 엔티티 클래스를 어떤 테이블로 생설할 것인지에 대한 정보를 담기 위한 어노테이션.
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id //PK에 해당하는 특정 필드를 @Id로 지정.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK를 자동으로 생성하고자 할 때 사용.
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;
}



/*
* Memo클래스는 Lombok의 @Geeter를 이용해서 Getter메서드를 생성하고 @Builder를 이용해서 객체를 생성할 수 있게 처리.
* @Builder아래 2개의 어노테이션은 @Builder의 컴파일 에러를 방지하기 위한 어노테이션.
*/

/* JpaRepository 상속 구조

    Repository
        ↑
    CrudRepository
        ↑
    PagingAndSortRepository
        ↑
    JpaRepository
 */