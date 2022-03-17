package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookService {
    Long register(GuestbookDTO dto);

    PageResultDTO<GuestbookDTO,Guestbook> getList(PageRequestDTO requestDTO);

    //java 8버전 부터는 인터페이스 실제 내용을 가지는 코드를 default라는 키워드로 생성할 수 있음.
    //이를 이용하면 기존에 추상클래스를 통해 전달해야 하는 실제 코드를 인터페이스에 선언할 수 있음.
    //추상클래스 생략이 가능해짐.
    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder().gno(dto.getGno())
                .title(dto.getTitle()).content(dto.getContent()).writer(dto.getWriter()).build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto =GuestbookDTO.builder().gno(entity.getGno()).title(entity.getTitle()).content(entity.getContent())
                .writer(entity.getWriter()).regDate(entity.getRegDate()).modDate(entity.getModDate()).build();

        return dto;
    }

    //방명록 조회 처리
    GuestbookDTO read(Long gno);

    //삭제 처리
    void remove(Long gno);

    //수정 처리
    void modify(GuestbookDTO dto);
}
