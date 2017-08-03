package com.gewara.movie.api.service.spider;

import java.sql.Timestamp;
public interface WorksStaffTeaseVoService {
	public void worksStaffTease();
	public void addCastProfile();
	public void clearTeaseData();
	public void resetCastProfileOrder(Timestamp addTime);
	public void checkCastProfileMovieRelationData();
	public void writeToSimpleCastProfileFromExcel(String id,String chineseName,String englishName);
	public void writeToMovieRelationFromExcel(String id,Long mtimeMovieId,Long gewaraMovieId,String status,String gewaraMovieName,String gewaraMovieEnglishName);
	public void writeToCastProfileMovieRelationFromExcel(String id,String mtimeActorId,Long mtimeMovieId,Long gewaraMovieId,String chinesename,String engname,String roleName);
	
}
