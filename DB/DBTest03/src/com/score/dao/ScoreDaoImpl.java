package com.score.dao;

import com.score.dto.ScoreDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.score.db.JDBCTemplate.*;

public class ScoreDaoImpl implements ScoreDao{

    @Override
    public List<ScoreDto> selectList() {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        Statement stmt = null;
        ResultSet rs = null;

        List<ScoreDto> list = new ArrayList<ScoreDto>();

        ScoreDto dto = new ScoreDto();

        try {

            stmt = con.createStatement();

            // 4.
            rs = stmt.executeQuery(SELECT_LIST_SQL);
            while (rs.next()) {

                dto.setS_name(rs.getString(1));
                dto.setS_kor(rs.getInt(2));
                dto.setS_eng(rs.getInt(3));
                dto.setS_math(rs.getInt(4));
                dto.setS_sum(rs.getInt(5));
                dto.setS_avg(rs.getDouble(6));
                dto.setS_grade(rs.getString(7));

                list.add(dto);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(stmt);
            close(con);
        }

        return list;
    }

    @Override
    public ScoreDto selectOne(String s_name) {
        return null;
    }

    @Override
    public int insert(ScoreDto dto) {

        // 1.
        // 2.
        Connection con = getConnection();

        // 3.
        PreparedStatement pstm = null;
        int res = 0;

        try {
            pstm = con.prepareStatement(INSERT_SQL);
            pstm.setString(1, dto.getS_name());
            pstm.setInt(2, dto.getS_kor());
            pstm.setInt(3, dto.getS_eng());
            pstm.setInt(4, dto.getS_math());
            pstm.setInt(5, dto.getS_sum());
            pstm.setDouble(6, dto.getS_avg());
            pstm.setString(7, dto.getS_grade());

            // 4.
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
    public int update(ScoreDto dto) {
        return 0;
    }

    @Override
    public int delete(String s_name) {
        return 0;
    }
}