package com.lsy.www.vo;

/**
 * 
 * <pre>
 * TODO 分页对象
 * </pre>
 * 
 * @author 梁舒艺
 * @version v1.0.0 2019年5月17日 梁舒艺 创建
 * @copyright 2019 {@link http://www.y-ke.com} All rights reserved. <br>
 *            注意：本内容仅限于广州云客网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Page {
	// 当前页
	private int pageNo = 1;
	// 每页页数,默认10条
	private int pageSize = 10;
	// 总页数
	private int totalPage;
	// 总记录数
	private int totalRecord;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 在设置页数时计算出总页数
		int totalPage = (totalRecord % pageSize == 0) ? (totalRecord / pageSize) : (totalRecord / pageSize + 1);

	}

}
