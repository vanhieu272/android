
/*insert table danhmuc*/
	INSERT INTO `nauan`.`danh_muc` (`madm`, `tendm`) VALUES ('mon-chinh', 'Món chính');
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

	UPDATE `nauan`.`danh_muc` SET `anh` = 'monchinh.jpg' WHERE (`id` = '1');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monga.jpg' WHERE (`id` = '2');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monbo.png' WHERE (`id` = '3');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monheo.png' WHERE (`id` = '4');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monchay.jpg' WHERE (`id` = '5');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monnhat.jpg' WHERE (`id` = '6');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'annhanh.jpg' WHERE (`id` = '7');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'lambanh.jpg' WHERE (`id` = '8');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'thucuong.jpg' WHERE (`id` = '9');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'diemtam.jpg' WHERE (`id` = '10');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'salad.jpg' WHERE (`id` = '11');
	UPDATE `nauan`.`danh_muc` SET `anh` = 'monlau.jpg' WHERE (`id` = '12');

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
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('1', 'tra-vai');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('2', 'tra-dao');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('3', 'tra-chanh');
	INSERT INTO `nauan`.`yeu_thich` (`user`, `ma_mon`) VALUES ('4', 'tra-vai');  
/*insert table thongbao*/
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('1', '1', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('2', '2', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('3', '3', 'thong bao', 1);
	INSERT INTO `nauan`.`thong_bao` (`user`, `ma_mon`, `noi_dung`, `status`) VALUES ('4', '1', 'thong bao', 1);  
/*insert table nguyen_lieu*/
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('cá lóc', '5', '1 kg');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('hành', '5', '4 củ');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('hành lá', '5', '4 nhánh');
	INSERT INTO `nauan`.`nguyen_lieu` (`ten`, `mon`, `dinh_luong`) VALUES ('ớt', '5', '2 quả');
/*insert table cong_thuc*/
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('Sơ chế cá', '5', 'ca-loc-kho-to-b1');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('Sơ chế các nguyên liệu còn lại', '5', 'ca-loc-kho-to-b2');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('Ướp cá', '5', 'ca-loc-kho-to-b3');
	INSERT INTO `nauan`.`cong_thuc` (`cong_thuc`, `mon`, `mact`) VALUES ('Làm cá lóc kho tộ', '5', 'ca-loc-kho-to-b4');
/*insert table anh_cong_thuc*/
	INSERT INTO `nauan`.`anh_cong_thuc` (`cong_thuc`, `anh`) VALUES ('1', 'socheca.jpg');
	INSERT INTO `nauan`.`anh_cong_thuc` (`cong_thuc`, `anh`) VALUES ('2', 'sochenguyenlieu.jpg');
	INSERT INTO `nauan`.`anh_cong_thuc` (`cong_thuc`, `anh`) VALUES ('3', 'uopca.jpg');
	INSERT INTO `nauan`.`anh_cong_thuc` (`cong_thuc`, `anh`) VALUES ('4', 'nauca.jpg');

 
	