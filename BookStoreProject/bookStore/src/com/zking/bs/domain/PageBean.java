package com.zking.bs.domain;

import java.util.List;

public class PageBean<T> {
		private List<T> list;  //当前页内容  查询
		private int currPage;  //当前页码      传递；
		private int pagesize;  //每页显示的条数  固定；
		private int totalCount; //总条数    查询；
		private int totalPage;  //总页数    计算
		public List<T> getList() {
			return list;
		}
		public void setList(List<T> list) {
			this.list = list;
		}
		public int getCurrPage() {
			return currPage;
		}
		public void setCurrPage(int currPage) {
			this.currPage = currPage;
		}
		public int getPagesize() {
			return pagesize;
		}
		public void setPagesize(int pagesize) {
			this.pagesize = pagesize;
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public int getTotalPage() {
			return (int) Math.ceil(totalCount*1.0/pagesize);
		}
		
		
		public PageBean() {}
			
		public PageBean(List<T> list, int currPage, int pagesize,
				int totalCount) {
			super();
			this.list = list;
			this.currPage = currPage;
			this.pagesize = pagesize;
			this.totalCount = totalCount;
			
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		@Override
		public String toString() {
			return "PageBean [list=" + list + ", currPage=" + currPage
					+ ", pagesize=" + pagesize + ", totalCount=" + totalCount
					+ ", totalPage=" + totalPage + "]";
		}
		
		
}
