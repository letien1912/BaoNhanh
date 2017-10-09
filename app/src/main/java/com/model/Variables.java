package com.model;

/**
 * Created by Le on 13-Jan-16.
 */
public class Variables {


    /* <---------- Bao VNexpress --------- >*/
    public static final String[] VNEXPRESS_ADDRESS = {
            "http://vnexpress.net/rss/tin-moi-nhat.rss",
            "http://vnexpress.net/rss/thoi-su.rss",
            "http://vnexpress.net/rss/the-gioi.rss",
            "http://vnexpress.net/rss/kinh-doanh.rss",
            "http://vnexpress.net/rss/giai-tri.rss",
            "http://vnexpress.net/rss/the-thao.rss",
            "http://vnexpress.net/rss/phap-luat.rss",
            "http://vnexpress.net/rss/giao-duc.rss",
            "http://vnexpress.net/rss/suc-khoe.rss",
            "http://vnexpress.net/rss/gia-dinh.rss",
            "http://vnexpress.net/rss/du-lich.rss",
            "http://vnexpress.net/rss/khoa-hoc.rss",
            "http://vnexpress.net/rss/so-hoa.rss",
            "http://vnexpress.net/rss/oto-xe-may.rss",
            "http://vnexpress.net/rss/cong-dong.rss",
            "http://vnexpress.net/rss/tam-su.rss",
            "http://vnexpress.net/rss/cuoi.rss"
    };
    public static final String[] VNEXPRESS_CAPTION = {"Trang Chủ", "Thời sự", "Thế giới", "Kinh Doanh", "Giải trí", "Thể Thao", "Pháp luật", "Giáo dục", "Sức khoẻ"
            , "Gia đình", "Du lịch", "Khoa học", "Số hoá", "Ô tô - Xe máy", "Cộng đồng", "Tâm sự", "Cười"};
    public static final String[] VNEXPRESS_HTLMJSOUP = {
            "div[class=main_content_detail width_common]",
            "div[class=relative_new]",
            "body[id=WIDGET]",
            "div[class=block_goithutoasoan]",
            "div[class=chose_category_khachsan]",
            "div[class=block_chiase_480]",
            "div[class=block_share right]",
            "div[class=block_timer_share]",
            "div[class=block_col_160 right]",
            "div[class=width_common mg_bottom_20]",
            "div[class=social_share width_common]",
            "div[class=block_input_comment width_common]",
            "div[class=block_tag width_common space_bottom_20]",
            "div[id=box_tinkhac_detail]",
    };


        /* <---------- Bao 24h --------- >*/

    public static final String[] _24H_CAPTION = {"Tin tức trong ngày", "Bóng đá", "An ninh - Hình sự", "Thời trang",
            "Thời trang Hi-tech", "Tài chính – Bất động sản", "Ẩm thực", "Làm đẹp", "Phim", "Giáo dục - du học", "Bạn trẻ - Cuộc sống",
            "Ca nhạc - MTV", "Thể thao", "Phi thường - kỳ quặc", "Công nghệ thông tin", "Ô tô - Xe máy", "Thị trường - Tiêu dùng", "Du lịch",
            "Sức khỏe đời sống", "Cười 24h", "Thế giới", "Đời sống Showbiz", "Giải trí"};
    public static final String[] _24H_ADDRESS = {"http://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
            "http://www.24h.com.vn/upload/rss/bongda.rss",
            "http://www.24h.com.vn/upload/rss/anninhhinhsu.rss",
            "http://www.24h.com.vn/upload/rss/thoitrang.rss",
            "http://www.24h.com.vn/upload/rss/thoitranghitech.rss",
            "http://www.24h.com.vn/upload/rss/taichinhbatdongsan.rss",
            "http://www.24h.com.vn/upload/rss/amthuc.rss",
            "http://www.24h.com.vn/upload/rss/lamdep.rss",
            "http://www.24h.com.vn/upload/rss/phim.rss",
            "http://www.24h.com.vn/upload/rss/giaoducduhoc.rss",
            "http://www.24h.com.vn/upload/rss/bantrecuocsong.rss",
            "http://www.24h.com.vn/upload/rss/canhacmtv.rss",
            "http://www.24h.com.vn/upload/rss/thethao.rss",
            "http://www.24h.com.vn/upload/rss/phithuongkyquac.rss",
            "http://www.24h.com.vn/upload/rss/congnghethongtin.rss",
            "http://www.24h.com.vn/upload/rss/otoxemay.rss",
            "http://www.24h.com.vn/upload/rss/thitruongtieudung.rss",
            "http://www.24h.com.vn/upload/rss/dulich.rss",
            "http://www.24h.com.vn/upload/rss/suckhoedoisong.rss",
            "http://www.24h.com.vn/upload/rss/cuoi24h.rss",
            "http://www.24h.com.vn/upload/rss/tintucquocte.rss",
            "http://www.24h.com.vn/upload/rss/doisongshowbiz.rss",
            "http://www.24h.com.vn/upload/rss/giaitri.rss",
    };

    public static final String[] _24H_HTLMHSOUP = {"div[class=text-conent]", "div[class=baiviet-bailienquan green-box-bg-light]", "table"};


    /* <---------- Bao Lao Dong --------- >*/
    public static final String[] LAODONG_CAPTION = {"Trang chu", "Công đoàn", "Thế giới", "Kinh tế", "Pháp luật", "Thể thao"
            , "Văn hóa", "Công nghệ", "Khám phá", "Xe+", "Giải trí", "Sức khỏe", "Bạn đọc"};

    public static final String[] LAPDONG_ADDRESS = {
            "http://laodong.com.vn/rss/home.rss",
            "http://laodong.com.vn/rss/cong-doan-58.rss",
            "http://laodong.com.vn/rss/the-gioi-62.rss",
            "http://laodong.com.vn/rss/kinh-te-63.rss",
            "http://laodong.com.vn/rss/phap-luat-65.rss",
            "http://laodong.com.vn/rss/the-thao-60.rss",
            "http://laodong.com.vn/rss/van-hoa-61.rss",
            "http://laodong.com.vn/rss/cong-nghe-66.rss",
            "http://laodong.com.vn/rss/kham-pha-108.rss",
            "http://laodong.com.vn/rss/xe-105.rss",
            "http://laodong.com.vn/rss/giai-tri-1184.rss",
            "http://laodong.com.vn/rss/suc-khoe-1166.rss",
            "http://laodong.com.vn/rss/ban-doc-75.rss"
    };

    public static final String[] LAODONG_HTMLJSOUP = {
            "div[class=main]",
            "p[style=margin-top: 35px;]",
            "div[class=clearfix]",
            "ul[class=article-relate clearfix]",
            "div[class=meta clearfix]",
            "div[class=more]",
            "div[class=stories-box-horizontal clearfix]",
            "div[class=clearfix newspaper]",
            "div[class=box company-info]",
            "div[class=video-cat]",
            "div[class=clearfix box hot-news-cat]",
            "div[class=comment-zone clearfix]",
            "div[class=social-footer clearfix]",
            "div[class=article-tag]",
            "ul[class=breadcrumb clearfix]",
    };

     /* <---------- Phap Luat --------- >*/


    public static final String[] PHAPLUAT_ADDRESS = {
            "http://phapluattp.vn/rss/home.rss",
            "http://phapluattp.vn/rss/thoi-su-1.rss",
            "http://phapluattp.vn/rss/phap-luat-114.rss",
            "http://phapluattp.vn/rss/the-gioi-8.rss",
            "http://phapluattp.vn/rss/kinh-te-13.rss",
            "http://phapluattp.vn/rss/giao-duc-21.rss",
            "http://phapluattp.vn/rss/suc-khoe-17.rss",
            "http://phapluattp.vn/rss/giai-tri-16.rss",
            "http://phapluattp.vn/rss/tinh-yeu-95.rss",
            "http://phapluattp.vn/rss/the-thao-22.rss",
            "http://phapluattp.vn/rss/an-ninh-trat-tu-23.rss",
            "http://phapluattp.vn/rss/xe-37.rss",
            "http://phapluattp.vn/rss/phong-su-35.rss",
            "http://phapluattp.vn/rss/ban-doc-24.rss",

    };
    public static final String[] PHAPLUAT_CAPTION = {
            "Trang chủ", "Thời sự", "Pháp luật", "Thế giới", "Kinh tế", "Giáo dục", "Sức khoẻ",
            "Giải trí", "Tình yêu", "Thể thao", "An ninh trật tự", "Xe", "Phóng sự", "Bạn đọc",
    };
    public static final String[] PHAPLUAT_HTMLJSOUP = {
            "div[class=main-contents]",
            "ul[class=tools]",
            "h3[class=breadcrums]",
            "div[class=cate-aside]",
            "div[class=contentinterested]",
            "div[class=tag]",
            "div[class=commentbox]",
            "div[class=related]",
            "div[class=_li]",
    };


    /* <---------- Tuoi Tre --------- >*/

    public static final String[] TUOITRE_ADDRESS = {"http://tuoitre.vn/rss/tt-tin-moi-nhat.rss",
            "http://tuoitre.vn/rss/tt-the-gioi.rss",
            "http://tuoitre.vn/rss/tt-kinh-te.rss",
            "http://tuoitre.vn/rss/tt-giao-duc.rss",
            "http://tuoitre.vn/rss/tt-van-hoa-giai-tri.rss",
            "http://tuoitre.vn/rss/tt-nhip-song-so.rss",
            "http://tuoitre.vn/rss/tt-chinh-tri-xa-hoi.rss",
            "http://tuoitre.vn/rss/tt-phap-luat.rss",
            "http://tuoitre.vn/rss/tt-song-khoe.rss",
            "http://tuoitre.vn/rss/tt-nhip-song-tre.rss",
            "http://tuoitre.vn/rss/tt-ban-doc.rss"};
    public static final String[] TUOITRE_CAPTION = {"Trang chủ",
            "Thế giới",
            "Kinh tế",
            "Giáo dục",
            "Văn hóa - Giải trí",
            "Nhịp sống số",
            "Chính trị - Xã hội",
            "Pháp luật",
            "Sống khỏe",
            "Nhịp sống trẻ",
            "Bạn đọc"};

    public static final String[] TUOITRE_HTMLJSOUP = {"section[class=main]",
            "div[class=right-side]",
            "ul[class=list-tool]",
            "div[class=highlight]"};

    /* <---------- Thanh Nien --------- >*/

    public static final String[] THANHNIEN_ADDRESS = {"http://thanhnien.vn/rss/home.rss",
            "http://thanhnien.vn/rss/chinh-tri-xa-hoi.rss",
            "http://thanhnien.vn/rss/kieu-bao.rss",
            "http://thanhnien.vn/rss/quoc-phong.rss",
            "http://thanhnien.vn/rss/kinh-te.rss",
            "http://thanhnien.vn/rss/the-gioi.rss",
            "http://thanhnien.vn/rss/the-thao.rss",
            "http://thanhnien.vn/rss/doi-song.rss",
            "http://thanhnien.vn/rss/giao-duc.rss",
            "http://thanhnien.vn/rss/toi-viet.rss",
            "http://thanhnien.vn/rss/cong-nghe-thong-tin.rss",
            "http://thanhnien.vn/rss/game.rss",
    };

    public static final String[] THANHNIEN_CAPTION = {
            "Trang chủ",
            "Thời sự",
            "Kiều bào",
            "Quốc phòng",
            "Kinh doanh",
            "Thế giới",
            "Thể thao",
            "Đời sống",
            "Giáo dục",
            "Tôi viết",
            "Công nghệ",
            "Game"
    };

    public static final String[] THANHNIEN_HTMLJSOUP = {
            "section[class=main-article]",
            "ul[class=sharing-zone clearfix]",
            "aside[id=ctl00_main_divAside]",
            "ul[class=tags]",
            "div[class=comment-zone clearfix]",
            "div[class=morenews]",
            "aside[id=divAside]",
            "div[class=video-page]",
            "section[class=morenews-zone clearfix]"
    };
    public static final String[] THANHNIEN_HTMLJSOUP_THETHAO = {
            "div[class=wcCont]",
            "div[class=categories1",
            "div[class=tukhoaitem]",
            "td[class=tt-mainRight]",
            "div[class=QC-bottom]",
            "div[class=article-ph]",
            "td[class=newsbm-L]",
            "td[class=newsbm-R]",

    };

        /* <---------- Tinh Te --------- >*/

    public static final String[] TINHTE_ADDRESS = {
            "https://tinhte.vn/rss",
    };

    public static final String[] TINHTE_CAPTION = {
            "Trang Chủ",
    };

    public static final String[] TINHTE_HTMLJSOUP = {
            "div[class=mainContainer]",
            "div[class=sub-title]",
            "aside[class=uix_mainSidebar uix_mainSidebar_right]",
            "div[id=similar_threads]",
            "div[class=firsPostSocialButtons]",
            "div[class=tagBlock TagContainer]",
            "div[class=pageNavLinkGroup]",
            "div[class=sharePage]",
    };


}
