package com.rj.bd.student.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

import com.rj.bd.root.utils.ExcelUtils;
import com.rj.bd.student.service.IStudentService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * student模块的c层
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public IStudentService userService;

	/**
	 * @desc   多表联查
	 * @return
	 */
	@RequestMapping("/queryAll")
	public List<Map<String, Object>> query(int page,int size) {
		System.out.println("query");

		List<Map<String, Object>> list = userService.queryAll(page,size);


		return list;

	}

	/**
	 * @desc   添加学生信息
	 * @return
	 */
	@RequestMapping("/add")
	public Map<String, Object> add(String uid, String uname, String sex, String birth,String unumber,String password,String cname,
	String school,String departname) {
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("Add");
		uid= UUID.randomUUID().toString();
		String cid=userService.queryByNametoId(cname);
		System.out.println(cid);
		String departid=userService.queryByNametodId(departname);
		userService.save(uid,uname,sex,birth,unumber,password,cid,school,departid);

		map.put("msc", 200);
		map.put("text", "添加成功");
        return map;
	}

	/**
	 * @desc   修改
	 * @return
	 */
	@RequestMapping("/update")
	public Map<String, Object> update(String uid,String uname,String unumber,String sex,String birth,String password,String cname,
									  String school,String departname) {
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println("update");
		System.out.println("departname"+departname);
		System.out.println("cname"+cname);
		String cid=userService.queryByNametoId(cname);
		System.out.println(cid);
		String departid=userService.queryByNametodId(departname);

		userService.update(uid,uname,unumber,sex,birth,password,cid,school,departid);
		map.put("msc", 200);
		map.put("text", "修改成功");
        return map;
	}


	/**
	 * @desc  根据id删除
	 * @return
	 */
	@RequestMapping("/delete")
	public Map<String, Object> delete(String uid) {
		Map<String, Object> map = new HashMap<String,Object>();

		System.out.println("delete");
		userService.DeleteUser(uid);
		map.put("msc", 200);
		map.put("text", "删除成功");
        return map;
	}

	/**
	 * @desc  双条件模糊查询
	 */
	@RequestMapping("/querybyname")
	public List<Map<String, Object>> queryByName(String uname,String unumber){
		System.out.println("---->queryByName");
		System.out.println("查询的名字uname："+uname);
		System.out.println("查询的学号unumber："+unumber);
		List<Map<String, Object>> list = userService.queryByName(uname,unumber);

		return list;

	}


	/**
	 * 根据id查询单条
	 */

	@RequestMapping("/queryOne")
	public List<Map<String, Object>> queryByOne(String uid){
		System.out.println("student-->queryByOne");
		List<Map<String, Object>> list = userService.queryOne(uid);
		return list;

	}

	/**
	 * 分页
	 * @return
	 */
	@RequestMapping("/getLogsCount")
	public Map<String,Object> getLogsCount(){
		Map<String, Object> map = new HashMap<String, Object>();


		map.put("msc",200);
		map.put("num", userService.getLosCount());

		return map;

	}

	/**
	 * @desc   生成excel
	 */
	@RequestMapping("/excel")
	public void excel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("excel");
		List<Map<String , Object>> list =userService.findAll();
		System.out.println(list);

		String filename = "学生信息表.xls";
		ExcelUtils excelUtils = new ExcelUtils();
		HSSFWorkbook workbook = new HSSFWorkbook();
		String sheetname = "学生信息";
		HSSFSheet sheet = workbook.createSheet(sheetname);
		String[] tableTop = {"学生ID", "学生姓名", "性别", "出生日期", "电话号码","密码","所属班级","学校名称","所属系别"};
		String[] columnName ={"uid", "uname", "sex", "birth", "unumber","password","cname","school","departname"};
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < tableTop.length; i++) {
			row.createCell(i).setCellValue(tableTop[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			HSSFRow row02 = sheet.createRow(i + 1);
			sheet.autoSizeColumn(i, true);
			Map<String, Object> map = list.get(i);
			System.out.println(map);
			for (int k = 0; k < columnName.length; k++) {
				System.out.println("2");
				row02.createCell(k).setCellValue((String)map.get(columnName[k]));
			}

		}
		excelUtils.setColumnAutoAdapter(sheet, list.size());
		response.setContentType("application/ms-excel;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				.concat(String.valueOf(URLEncoder.encode("学生信息表" + ".xls",
						"UTF-8"))));
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();


	}

}
