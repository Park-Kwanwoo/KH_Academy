package com.mvc.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.mvc.db.JDBCTemplates.*;
import com.mvc.dto.MVCDto;

public class MVCDaoImpl implements MVCDao {


    @Override
    public List<MVCDto> selectList() {

        Connection con = getConnection();

        Statement stmt = null;
        //PreparedStatement pstm = null;
        ResultSet rs = null;
        List<MVCDto> list = new ArrayList<MVCDto>();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SELECT_LIST_SQL);
            //pstm = con.prepareStatement(SELECT_LIST_SQL);
            //rs = pstm.executeQuery();


            while (rs.next()) {
                MVCDto dto = new MVCDto();
                dto.setSeq(rs.getInt(1));
                dto.setWriter(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setRegDate(rs.getDate(5));

                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            //close(pstm);
            close(stmt);
            close(con);
        }

        return list;
    }

    @Override
    public MVCDto selectOne(int seq) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        MVCDto dto = new MVCDto();

        try {
            pstm = con.prepareStatement(SELECT_ONE_SQL);
            pstm.setInt(1, seq);
            rs = pstm.executeQuery();
            System.out.println("쿼리 실행");

            while (rs.next()) {
                dto.setSeq(rs.getInt(1));
                dto.setWriter(rs.getString(2));
                dto.setTitle(rs.getString(3));
                dto.setContent(rs.getString(4));
                dto.setRegDate(rs.getDate(5));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstm);
            close(con);
        }

        return dto;
    }

    @Override
    public int insert(MVCDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(INSERT_SQL);
            pstm.setString(1, dto.getWriter());
            pstm.setString(2, dto.getTitle());
            pstm.setString(3, dto.getContent());
            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          close(pstm);
          close(con);
        }
        return res;
    }

    @Override
    public int update(MVCDto dto) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;
        try {
            pstm = con.prepareStatement(UPDATE_SQL);
            pstm.setString(1, dto.getTitle());
            pstm.setString(2, dto.getContent());
            pstm.setInt(3, dto.getSeq());

            res = pstm.executeUpdate();
            if (res > 0) {
                commit(con);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }

        return res;
    }

    @Override
    public int delete(int seq) {

        Connection con = getConnection();

        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(DELETE_SQL);
            pstm.setInt(1, seq);
            res = pstm.executeUpdate();

            if (res > 0) {
                commit(con);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstm);
            close(con);
        }
        return res;
    }
}
