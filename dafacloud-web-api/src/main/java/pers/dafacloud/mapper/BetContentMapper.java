package pers.dafacloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BetContentMapper {

    List<String> getBetContentList(@Param("contentType") int contentType, @Param("lotteryType") String lotteryType);

    int insertBetContent(List<Map> list);
}
