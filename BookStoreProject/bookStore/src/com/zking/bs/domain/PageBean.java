package com.zking.bs.domain;

import java.util.List;

public class PageBean<T> {
		private List<T> list;  //��ǰҳ����  ��ѯ
		private int currPage;  //��ǰҳ��      ���ݣ�
		private int pagesize;  //ÿҳ��ʾ������  �̶���
		private int totalCount; //������    ��ѯ��
		private int totalPage;  //��ҳ��    ����
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
