package com.muldel.dao;

import com.muldel.dto.MDBoardDto;

import java.util.List;

public interface MDBoardDao {

    String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " +
                             " FROM MDBOARD " +
                             " ORDER BY SEQ DESC ";
    String SELECT_ONE_SQL = "";
    String INSERT_SQL = "";
    String UPDATE_SQL = "";
    String DELETE_SQL = " DELETE FROM MDBOARD " +
                        " WHERE SEQ = ? ";

    public List<MDBoardDto> selectList();
    public MDBoardDto selectOne(int seq);
    public int insert(MDBoardDto dto);
    public int update(MDBoardDto dto);
    public int delete(int seq);

    public int multiDelete(String [] seqs);
}
