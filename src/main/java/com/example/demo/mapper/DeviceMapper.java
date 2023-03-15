package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Device;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<Device> {

    @Select("Select * from tbl_devices")
    List<Device> findAll();

    @Select("Select * from tbl_devices where principle= #{name}")
    List<Device>findOwn(String name);

    @Insert("insert into tbl_devices(`name`, `number`, `produceDate`, `manufacture`, `principle`, `phoneNumber`,`interval`,`needMaintain`,`local`)" +
                         " values (#{name},#{number},#{produceDate},#{manufacture},#{principle},#{phoneNumber},#{interval},#{needMaintain},#{local})")
    int saveA(String name, String number, String produceDate, String manufacture, String principle, String phoneNumber, int interval, int needMaintain, String local);
}
