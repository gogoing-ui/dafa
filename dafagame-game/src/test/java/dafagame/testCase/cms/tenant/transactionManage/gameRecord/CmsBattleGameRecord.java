package dafagame.testCase.cms.tenant.transactionManage.gameRecord;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;
import pers.utils.urlUtils.UrlBuilder;
import pers.utils.dafaRequest.DafaRequest;

/**
 * 交易管理 >游戏记录查询 > 对战游戏记录
 */
public class CmsBattleGameRecord {
    private static String path = "/v1/game/cmsBattleGameRecord";
    private static String cmsBankerGameRecordInfo = "/v1/game/cmsBattleGameRecordInfo";


    @Test(description = "测试")
    public static void test01() {
        String result = DafaRequest.get(1,
                UrlBuilder.custom()
                        .url(path)
                        .addBuilder("userName", "")
                        .addBuilder("gameCode", "") //101 百人牛牛，102
                        .addBuilder("gameState", "") // 结果 1输，2赢，0游戏中，3系统撤单
                        .addBuilder("roundType", "") //场次 101 4倍场,102 10倍场
                        .addBuilder("roomNumber", "") //房号
                        .addBuilder("inning", "") //局号
                        .addBuilder("recordCode", "") //流水号
                        .addBuilder("startTime", "2019-07-01")
                        .addBuilder("endTime", "2019-07-18")
                        .addBuilder("pageSize", "20")
                        .addBuilder("pageNum", "1")
                        .fullUrl());
        JSONArray list = JSONObject.fromObject(result).getJSONObject("data").getJSONArray("list");
        System.out.println("数据量" + list.size());
        if(list.size()==0){
            System.out.println(result);
            return;
        }
        for (Object ob : list) {
            System.out.println(ob);
            String cmsMultiGameRecordInfoResult = DafaRequest.get(1,UrlBuilder.custom()
                    .url(cmsBankerGameRecordInfo).addBuilder("id", ((JSONObject) ob).getString("id")).fullUrl());
            System.out.println(cmsMultiGameRecordInfoResult);
        }


    }
}
