/*insert table danhmuc*/
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-chinh', 'Món chính');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-nuong', 'Món nướng');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-ga', 'Món gà');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-bo', 'Món bò');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-heo', 'Món heo');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-chay', 'Món chay');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-nhat', 'Món nhật');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('an-nhanh', 'Ăn nhanh');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('lam-banh', 'Làm bánh');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('thuc-uong', 'Thức uống');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('diem-tam', 'Điểm tâm');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('salad', 'Salad');
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-lau', 'Món lẩu');

/*insert table monan*/
	INSERT INTO `nauan`.`mon_an` (`anh`, `luot_thich`, `luot_xem`, `ma_mon`, `nguoi_dang`, `ten_mon`, `madm`) VALUES ('travai.jpg', '100', '100', 'tra-vai', 'user1', 'Trà vải', '9');
	INSERT INTO `nauan`.`mon_an` (`anh`, `luot_thich`, `luot_xem`, `ma_mon`, `nguoi_dang`, `ten_mon`, `madm`) VALUES ('tradao.jpg', '100', '200', 'tra-dao', 'user2', 'Trà đào', '9');
	INSERT INTO `nauan`.`mon_an` (`anh`, `luot_thich`, `luot_xem`, `ma_mon`, `nguoi_dang`, `ten_mon`, `madm`) VALUES ('trachanh.jpg', '100', '100', 'tra-chanh', 'user3', 'Trà chanh', '9');
	INSERT INTO `nauan`.`mon_an` (`anh`, `luot_thich`, `luot_xem`, `ma_mon`, `nguoi_dang`, `ten_mon`, `madm`) VALUES ('tratac.jpg', '50', '50', 'tra-tac', 'user1', 'Trà tắc', '9');
	INSERT INTO `nauan`.`mon_an` (`anh`, `luot_thich`, `luot_xem`, `ma_mon`, `nguoi_dang`, `ten_mon`, `madm`) VALUES ('caloc.jpg', '50', '50', 'ca-loc-kho-to', 'user1', 'Cá lóc kho tộ', '1');
/*insert table user*/
	INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('vandong', '123456', '1');
	INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('nhuy', '123456', '1');
	INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('hha', '123456', '1');
	INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('chihieu', '123456', '1');
    INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('user1', '123456', '1');
    INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('user2', '123456', '1');
    INSERT INTO `nauan`.`user` (`user_name`, `pass_word`, `status`) VALUES ('user3', '123456', '1');
/*insert table yeuthich*/
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('vandong', 'tra-vai');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('nhuy', 'tra-dao');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('hha', 'tra-chanh');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('chihieu', 'tra-vai');  
/*insert table thongbao*/
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('vandong', 'tra-vai', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('nhuy', 'tra-dao', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('hha', 'tra-chanh', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('chihieu', 'tra-vai', 'thong bao', 1);  
/*insert table nguyen_lieu*/
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('cá lóc', '5', '1 kg');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('hành', '5', '4 củ');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('hành lá', '5', '4 nhánh');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('ớt', '5', '2 quả');
/*insert table cong_thuc*/
	/*INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('vandong', '123456', '1');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('nhuy', '123456', '1');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('hha', '123456', '1');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('chihieu', '123456', '1');*/
 
	