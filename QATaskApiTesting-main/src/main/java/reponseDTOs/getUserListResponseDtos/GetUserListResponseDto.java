package reponseDTOs.getUserListResponseDtos;

import lombok.Data;

import java.util.List;

@Data
public class GetUserListResponseDto {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<DataResponseDto> data = null;
    private SupportResponseDto support;
}
