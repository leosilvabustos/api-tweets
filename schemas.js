//Cambiar base de datos
//Usar base de datos
use apitweets;

//Crear collecciones
db.createCollection("tweets");
db.createCollection("users");


//dummy users
db.users.insert([{
	_id: "e99dcecad980465a96ca76ce14df842f",
	name: "Pedro Soto",
    profileUrl: "pedro-soto",
    createdAt: new Date("2017-05-18T16:00:00Z"),
    following: false
},{
	_id: "4ae7959473b94763bb946c2ce82bf9d0",
	name: "Carlos duran",
    profileUrl: "carlos-duran",
    createdAt: new Date("2018-01-18T16:00:00Z"),
    following: false
},
{
	_id: "288c295c916d41f1b6cab52b8a7169d5",
	name: "Francisco de la puente",
    profileUrl: "f-de-la-puente",
    createdAt: new Date("2018-03-11T18:00:00Z"),
    following: true
},
{
	_id: "0e71bb3c795a4e0591d914f0e00fd03c",
	name: "Ricardo Michea",
    profileUrl: "r-michea",
    createdAt: new Date("2016-02-21T08:00:00Z"),
    following: false
},{
	_id: "0f6222b61a814c87a351d4d341766f7a",
	name: "Claudio Lopez",
    profileUrl: "c-lopez",
    createdAt: new Date("2017-09-24T16:00:00Z"),
    following: true
}]);

//dummy tweets
db.tweets.insert([{
	text: "Text 1 Tweet 1",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet1"],
    user: "e99dcecad980465a96ca76ce14df842f"
},{
	text: "Text2 Tweet 2",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet2"],
    user: "4ae7959473b94763bb946c2ce82bf9d0"
},{
	text: "Text 3 Tweet 3",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet3"],
    user: "288c295c916d41f1b6cab52b8a7169d5"
},{
	text: "Text 4 4",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet4"],
    user: "0e71bb3c795a4e0591d914f0e00fd03c"
},{
	text: "Text 5 Tweet 5",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet5"],
    user: "0f6222b61a814c87a351d4d341766f7a"
},{
	text: "Text 6 Tweet 6",
    source: "WEB",
    truncated: false,
    inReplyToStatus: 0,
    inReplyToUser: null,
    inReplyToScreen: null,
    createdAt: new Date(),
    favorited: false,
    favoritedCount: 0,
    retweeted: false,
    retweetedCount: 0,
    urls: [],
    hashtags: ["#tweet6"],
    user: "0f6222b61a814c87a351d4d341766f7a"
}]);