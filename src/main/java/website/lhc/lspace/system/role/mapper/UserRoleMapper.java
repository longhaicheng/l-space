package website.lhc.lspace.system.role.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: l-space
 * @Package: website.lhc.lspace.system.role.mapper
 * @ClassName: UserRoleMapper
 * @Author: lhc
 * @Description: TODO
 * @Date: 2020/4/9 上午 12:26
 */
public interface UserRoleMapper {

    /**
     * 插入用户关系表
     *
     * @param userId userId
     * @param roleId roleId
     * @return 插入的ID
     */
    int insertUserRole(@Param(value = "userId") Integer userId, @Param(value = "roleId") Integer roleId);
}
