package com.duanxin.excle.service;

import com.alibaba.excel.EasyExcel;
import com.duanxin.excle.contains.DietContain;
import com.duanxin.excle.contains.FavoriteDishesContain;
import com.duanxin.excle.contains.NationContain;
import com.duanxin.excle.contains.TasteTypeContain;
import com.duanxin.excle.dto.FmsMealRecommendationParametersDto;
import com.duanxin.excle.dto.FmsUserLikeDto;
import com.duanxin.excle.dto.UmsUserInfoDto;
import com.duanxin.excle.mapper.FmsMealRecommendationParametersMapper;
import com.duanxin.excle.mapper.FmsUserLikeMapper;
import com.duanxin.excle.mapper.UmsUserInfoMapper;
import com.duanxin.excle.model.FmsMealRecommendationParameters;
import com.duanxin.excle.model.FmsUserLike;
import com.duanxin.excle.model.UmsUserInfo;
import com.duanxin.excle.test.SimpleTest;
import com.duanxin.excle.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @author duanxin
 * @version 1.0
 * @date 2019/11/28 9:51
 */
@Service
public class SaveDataService {

    @Resource
    private UmsUserInfoMapper umsUserInfoMapper;
    @Resource
    private FmsUserLikeMapper fmsUserLikeMapper;
    @Resource
    private FmsMealRecommendationParametersMapper fmsMealRecommendationParametersMapper;

    public void insertUmsUserInfo(List<UmsUserInfoDto> list) {
            list.forEach(user -> {
                UmsUserInfo umsUserInfo = UmsUserInfo.builder().
                        aid(Integer.parseInt(user.getAid())).
                        jobNumber(user.getJobNumber()).
                        userName(user.getUserName()).
                        password(MD5Util.md5("123456")).
                        gender("男".equals(user.getGender()) ? "0" : "1").
                        phone(user.getPhone()).
                        email(user.getEmail()).
                        operateIp("0.0.0.0").
                        operator("李四").
                        build();
                umsUserInfoMapper.insertSelective(umsUserInfo);
            });
    }

    public void test() {
        umsUserInfoMapper.insertSelective(UmsUserInfo.builder().
                aid(400000001).
                jobNumber("4030200001").
                userName("qqq").
                password("EA48576F30BE1669971699C09AD05C94").
                gender("0").
                phone("10086").
                email("10086@163.com").
                operateIp("0.0.0.0").
                operator("李四").
                build());
    }

    public void insertFmsUserLike(List<FmsUserLikeDto> list) {
        list.forEach(userLike -> {
            System.out.println(userLike);
            fmsUserLikeMapper.insertSelective(FmsUserLike.
                    builder().
                    uid(userLike.getUid()).
                    nation(NationContain.getTypeId(userLike.getNation())).
                    area(userLike.getArea()).
                    tasteType1(TasteTypeContain.getTypeId(userLike.getTasteType1())).
                    tasteType2(TasteTypeContain.getTypeId(userLike.getTasteType2())).
                    favoriteDishes1(FavoriteDishesContain.getTypeId(userLike.getFavoriteDishes1())).
                    favoriteDishes2(FavoriteDishesContain.getTypeId(userLike.getFavoriteDishes2())).
                    diet(DietContain.getTypeId(userLike.getDiet())).
                    build());
        });
    }

    public void insertFmsMealRecommendationParameters(List<FmsMealRecommendationParametersDto> list) {
        list.forEach(parameter -> {
            fmsMealRecommendationParametersMapper.insertSelective(FmsMealRecommendationParameters.
                    builder().
                    uid(parameter.getUid()).
                    height(parameter.getHeight()).
                    weight(parameter.getWeight()).
                    build());
        });
    }

    public void writeIdToFile() {
        String fileName = SimpleTest.class.getResource("/").getPath() + "excleFile" + File.separator + "用户属性.xls";
        List list = saveData();
        list.forEach(System.out::println);
        EasyExcel.write(fileName, UmsUserInfo.class).sheet().doWrite(list);
    }

    private List saveData() {
        return umsUserInfoMapper.selectWithId();
    }
}
