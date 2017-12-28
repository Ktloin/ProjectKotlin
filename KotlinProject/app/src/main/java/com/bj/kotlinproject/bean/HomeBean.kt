package com.bj.kotlinproject.bean

/**
 * Created by 吴丽杰 on 2017/12/28.
 */

class HomeBean {


    var nextPageUrl: String? = null
    var nextPublishTime: Long = 0
    var newestIssueType: String? = null
    var dialog: Any? = null
    var issueList: List<IssueListBean>? = null

    class IssueListBean {


        var releaseTime: Long = 0
        var type: String? = null
        var date: Long = 0
        var publishTime: Long = 0
        var count: Int = 0
        var itemList: List<ItemListBean>? = null

        class ItemListBean {


            var type: String? = null
            var data: DataBean? = null
            var tag: Any? = null
            var id: Int = 0
            var adIndex: Int = 0

            class DataBean {
                var dataType: String? = null
                var id: Int = 0
                var title: String? = null
                var description: String? = null
                var image: String? = null
                var actionUrl: String? = null
                var adTrack: Any? = null
                var shade: Boolean = false
                var label: Any? = null
                var labelList: Any? = null
                var header: Any? = null

                var playUrl: String? = null
                var author: AuthorBean? = null
                var cover: CoverBean? = null

                class AuthorBean {
                    var icon: String? = null
                }

                class CoverBean {
                    var feed: String? = null
                    var blurred: String? = null
                    var detail: String? = null
                    var homepage: String? = null
                }


            }
        }
    }
}
