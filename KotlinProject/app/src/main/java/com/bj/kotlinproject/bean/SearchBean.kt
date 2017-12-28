package com.bj.kotlinproject.bean

/**
 * Created by 郑文杰 on 2017/12/28.
 */

class SearchBean {


    var count: Int = 0
    var total: Int = 0
    var nextPageUrl: String? = null
    var adExist: Boolean = false
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
            var slogan: Any? = null
            var description: String? = null
            var provider: ProviderBean? = null
            var category: String? = null
            var author: AuthorBean? = null
            var cover: CoverBean? = null
            var playUrl: String? = null
            var thumbPlayUrl: Any? = null
            var duration: Int = 0
            var webUrl: WebUrlBean? = null
            var releaseTime: Long = 0
            var library: String? = null
            var consumption: ConsumptionBean? = null
            var campaign: Any? = null
            var waterMarks: Any? = null
            var adTrack: Any? = null
            var type: String? = null
            var titlePgc: Any? = null
            var descriptionPgc: Any? = null
            var remark: Any? = null
            var idx: Int = 0
            var shareAdTrack: Any? = null
            var favoriteAdTrack: Any? = null
            var webAdTrack: Any? = null
            var date: Long = 0
            var promotion: Any? = null
            var label: Any? = null
            var descriptionEditor: String? = null
            var collected: Boolean = false
            var played: Boolean = false
            var lastViewTime: Any? = null
            var playlists: Any? = null
            var src: Any? = null
            var playInfo: List<PlayInfoBean>? = null
            var tags: List<TagsBean>? = null
            var labelList: List<*>? = null
            var subtitles: List<*>? = null

            class ProviderBean {
                /**
                 * name : 乐视
                 * alias : letv
                 * icon : http://img.kaiyanapp.com/784da0db524cf8e1448574a764dcdca6.png
                 */

                var name: String? = null
                var alias: String? = null
                var icon: String? = null
            }

            class AuthorBean {


                var id: Int = 0
                var icon: String? = null
                var name: String? = null
                var description: String? = null
                var link: String? = null
                var latestReleaseTime: Long = 0
                var videoNum: Int = 0
                var adTrack: Any? = null
                var follow: FollowBean? = null
                var shield: ShieldBean? = null
                var approvedNotReadyVideoCount: Int = 0
                var ifPgc: Boolean = false

                class FollowBean {


                    var itemType: String? = null
                    var itemId: Int = 0
                    var followed: Boolean = false
                }

                class ShieldBean {


                    var itemType: String? = null
                    var itemId: Int = 0
                    var shielded: Boolean = false
                }
            }

            class CoverBean {


                var feed: String? = null
                var detail: String? = null
                var blurred: String? = null
                var sharing: Any? = null
                var homepage: Any? = null
            }

            class WebUrlBean {


                var raw: String? = null
                var forWeibo: String? = null
            }

            class ConsumptionBean {


                var collectionCount: Int = 0
                var shareCount: Int = 0
                var replyCount: Int = 0
            }

            class PlayInfoBean {


                var height: Int = 0
                var width: Int = 0
                var name: String? = null
                var type: String? = null
                var url: String? = null
                var urlList: List<UrlListBean>? = null

                class UrlListBean {

                    var name: String? = null
                    var url: String? = null
                    var size: Int = 0
                }
            }

            class TagsBean {


                var id: Int = 0
                var name: String? = null
                var actionUrl: String? = null
                var adTrack: Any? = null
                var desc: Any? = null
                var bgPicture: String? = null
                var headerImage: String? = null
                var tagRecType: String? = null
            }
        }
    }
}
