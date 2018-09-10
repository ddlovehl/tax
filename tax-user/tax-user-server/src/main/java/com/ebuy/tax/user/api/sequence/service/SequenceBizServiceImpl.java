package com.ebuy.tax.user.api.sequence.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebuy.tax.common.constants.SysConstant;
import com.ebuy.tax.common.enums.ServerEnums;
import com.ebuy.tax.common.utils.StringUtils;
import com.ebuy.tax.user.api.sequence.dao.ISequenceDao;
import com.ebuy.tax.user.api.sql.entity.AdapterSql;

import lombok.extern.slf4j.Slf4j;

/**
 * @Package com.ebuy.tax.user.api.sequence.dao
 * @author hdq
 * @Date 2018-09-08 16:57:34
 * @Description
 */
@Slf4j
@Transactional
@Service(value = "sequenceBizService")
public class SequenceBizServiceImpl implements SequenceBizService {

    @Resource(name = "sequenceDao")
    private ISequenceDao sequenceDao;

	@Override
	public String genAdminUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String genMerchantUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String genSubMerchantUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取普通用户id  13
	 */
	@Override
	public String genCustomerUserId() {
		int i = (int) (Math.random()*9000)+1000;
		String seq = nextCustomerSeq();
		String randomNo = String.valueOf(i);
		StringBuilder sb = new StringBuilder();
		sb.append(seq.substring(0, 2)).append(randomNo.substring(0, 1))
		.append(seq.substring(2, 4)).append(randomNo.substring(1, 2))
		.append(seq.substring(4, 6)).append(randomNo.substring(2, 3))
		.append(seq.substring(6,8)).append(randomNo.substring(3, 4))
		.append(seq.substring(8,seq.length())
		);
		return sb.toString();
	}
	
	/**
	 * 获取公司id
	 */
	@Override
	public String genCompanyId(String userId) {
		String seq = nextCompanySeq();
		StringBuilder sb = new StringBuilder();
		sb.append(userId).append(seq)
		;
		return sb.toString();
	}

	/**
	 * 获取服务id
	* @author dd
	* @date 2018年9月10日
	 */
	@Override
	public String genServerId(String serverType) {
		
		StringBuilder sb1 = new StringBuilder();
		if(StringUtils.isNotEmpty(ServerEnums.ServerType.getByCode(serverType))) {
			sb1.append(serverType);
		}else {
			sb1.append("0");
		}
		sb1.append(new SimpleDateFormat("yyyyMMddHH").format(new Date()));
		
		
		int i = (int) (Math.random()*900000)+100000;
		String seq = nextCustomerSeq();
		String randomNo = String.valueOf(i);
		StringBuilder sb = new StringBuilder();
		sb.append(seq.substring(0, 1)).append(randomNo.substring(0, 1))
		.append(seq.substring(1, 2)).append(randomNo.substring(1, 2))
		.append(seq.substring(2, 3)).append(randomNo.substring(2, 3))
		.append(seq.substring(3,4)).append(randomNo.substring(3, 4))
		.append(seq.substring(4,5)).append(randomNo.substring(4, 5))
		.append(seq.substring(5,seq.length())).append(randomNo.substring(5, 6)
		);
		return sb1.append(sb).toString();
	}

	@Override
	public String genSubServerId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private String nextCustomerSeq() {
		AdapterSql sql = new AdapterSql();
		sql.setSql("SELECT nextval('" + SysConstant.Sequence.SEQ_CUSTOMER_USER_ID + "') AS VALUE");
		return sequenceDao.select(sql).getValue();
	}
	
	private String nextCompanySeq() {
		AdapterSql sql = new AdapterSql();
		sql.setSql("SELECT nextval('" + SysConstant.Sequence.SEQ_COMPANY_ID + "') AS VALUE");
		return sequenceDao.select(sql).getValue();
	}
	
	
	private String nextServerSeq() {
		AdapterSql sql = new AdapterSql();
		sql.setSql("SELECT nextval('" + SysConstant.Sequence.SEQ_SERVER_ID + "') AS VALUE");
		return sequenceDao.select(sql).getValue();
	}

    
}

