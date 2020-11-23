package com.osg.movieapppractice.data.model

data class MovieComponent(
    val status: String? = null,
    val statusMessage: String? = null,
    val data: Data? = null,
    val meta: Meta? = null
)

data class Data(
    val movieCount: Long? = null,
    val limit: Long? = null,
    val pageNumber: Long? = null,
    val movies: List<Movie>? = null
)

data class Movie(
    val id: Long? = null,
    val url: String? = null,
    val imdbCode: String? = null,
    val title: String? = null,
    val titleEnglish: String? = null,
    val titleLong: String? = null,
    val slug: String? = null,
    val year: Long? = null,
    val rating: Double? = null,
    val runtime: Long? = null,
    val genres: List<String>? = null,
    val summary: String? = null,
    val descriptionFull: String? = null,
    val synopsis: String? = null,
    val ytTrailerCode: String? = null,
    val language: String? = null,
    val mpaRating: String? = null,
    val backgroundImage: String? = null,
    val backgroundImageOriginal: String? = null,
    val smallCoverImage: String? = null,
    val mediumCoverImage: String? = null,
    val largeCoverImage: String? = null,
    val state: String? = null,
    val torrents: List<Torrent>? = null,
    val dateUploaded: String? = null,
    val dateUploadedUnix: Long? = null
)

data class Torrent(
    val url: String? = null,
    val hash: String? = null,
    val quality: Quality? = null,
    val type: Type? = null,
    val seeds: Long? = null,
    val peers: Long? = null,
    val size: String? = null,
    val sizeBytes: Long? = null,
    val dateUploaded: String? = null,
    val dateUploadedUnix: Long? = null
)

enum class Quality {
    The1080P,
    The2160P,
    The3D,
    The720P
}

enum class Type {
    bluray,
    web
}

data class Meta(
    val serverTime: Long? = null,
    val serverTimezone: String? = null,
    val apiVersion: Long? = null,
    val executionTime: String? = null
)
