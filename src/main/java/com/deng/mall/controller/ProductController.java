package com.deng.mall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;


import com.deng.mall.utils.UpfileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="product")
public class ProductController {

	@RequestMapping(value = "upFile", method = RequestMethod.POST)
	@ResponseBody
	public List<String> upfileProductImg(@RequestParam("productImgs")MultipartFile[] productImgs, HttpServletRequest request) {
		String picPath = request.getServletContext().getRealPath("templates/images/");
		List<String> productImgPaths = UpfileUtils.loadFileList(productImgs, picPath);
        return productImgPaths;
	}
	


}
