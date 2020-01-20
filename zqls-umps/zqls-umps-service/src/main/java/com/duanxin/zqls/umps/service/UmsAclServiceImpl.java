package com.duanxin.zqls.umps.service;

import com.duanxin.zqls.umps.ao.UmsAclAo;
import com.duanxin.zqls.umps.api.UmsAclService;
import com.duanxin.zqls.umps.mapper.UmsAclMapper;
import com.duanxin.zqls.umps.model.UmsAcl;
import com.duanxin.zqls.umps.vo.UmsAclVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 权限Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2020/1/16 9:24
 */
@Service(version = "0.0.1")
public class UmsAclServiceImpl implements UmsAclService {

    @Resource
    private UmsAclMapper umsAclMapper;

    @Override
    public int saveUmsAcl(UmsAclVo umsAclVo) {
        UmsAcl umsAcl = UmsAcl.builder().
                code(umsAclVo.getCode()).
                name(umsAclVo.getName()).
                remark(umsAclVo.getRemark()).
                status(umsAclVo.getStatus()).
                type(umsAclVo.getType()).
                url(umsAclVo.getUrl()).
                operateIp("0.0.0.0").
                operateTime(new Date()).
                operator("李四").
                build();
        return umsAclMapper.insertSelective(umsAcl);
    }

    @Override
    public UmsAclAo selectUmsAclByPrimaryKey(Integer id) {
        UmsAclAo umsAclAo = new UmsAclAo();
        UmsAcl umsAcl = umsAclMapper.selectByPrimaryKey(id);
        if (umsAcl == null || umsAcl.getStatus().equals(Byte.parseByte("1"))) {
            umsAclAo.setCheckCode(1);
        }
        umsAclAo.setUmsAcl(umsAcl);
        return umsAclAo;
    }

    @Override
    public PageInfo<UmsAclAo> selectAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<UmsAcl> umsAcls = umsAclMapper.selectAll();
        List<UmsAclAo> umsAclAos = Lists.newArrayList();
        umsAcls.forEach(u -> {
            UmsAclAo umsAclAo = new UmsAclAo();
            if (u.getStatus().equals(Byte.parseByte("1"))) {
                umsAclAo.setCheckCode(1);
            }
            umsAclAo.setUmsAcl(u);
            umsAclAos.add(umsAclAo);
        });
        return new PageInfo<UmsAclAo>(umsAclAos);
    }

    @Override
    public int deleteUmsAclByPrimaryKey(Integer id) {
        return umsAclMapper.updateByPrimaryKeySelective(UmsAcl.builder().
                id(id).
                status(Byte.parseByte("1")).
                operateIp("0.0.0.0").
                operateTime(new Date()).
                operator("李四").
                build()
        );
    }

    @Override
    public UmsAclAo updateUmsAcl(UmsAcl umsAcl) {
        UmsAclAo umsAclAo = new UmsAclAo();
        umsAcl.setOperateIp("0.0.0.0");
        umsAcl.setOperateTime(new Date());
        umsAcl.setOperator("李四");
        umsAclMapper.updateByPrimaryKeySelective(umsAcl);
        UmsAcl umsAcl1 = umsAclMapper.selectByPrimaryKey(umsAcl.getId());
        if (umsAcl1 == null || umsAcl1.getStatus().equals(Byte.parseByte("1"))) {
            umsAclAo.setCheckCode(1);
        }
        umsAclAo.setUmsAcl(umsAcl1);
        return umsAclAo;
    }
}
