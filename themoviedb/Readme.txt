//Master
Requette sur themoviedb.org
https://developers.themoviedb.org/3/getting-started/search-and-query-for-details

api_key=bd5b73151b4a5a2ac5b34aca8bfe555a


1- Exemple de recherche
https://api.themoviedb.org/3/search/movie?api_key=bd5b73151b4a5a2ac5b34aca8bfe555a&language=en-US&query=matrix&page=1&include_adult=false

2- exemple de detail : credits -> infos acteurs
https://api.themoviedb.org/3/movie/603?api_key=bd5b73151b4a5a2ac5b34aca8bfe555a&append_to_response=credits,videos


=============== Mango ==========
lancer cmd, puis : C:\Program Files\MongoDB\Server\3.4\bin>mongod
puis eventuelemnt RobotMonGo
db.getCollection('restaurants').find({})
db.getCollection('restaurants').find({ObjectId("59f60919599aff8e59c9bcd3")})
db.getCollection('restaurants').find({"cuisine":"Francaise"})
db.restaurants.find( { "grades.grade": "A" } )
db.getCollection('films').find({"credits.cast.name":"Keanu Reeves"})
db.getCollection('films').find({"credits.cast.name":"Keanu Reeves","credits.cast.job":null})
db.getCollection('films').find({"original_title":"Albert"})
db.getCollection('films').find({"original_title":{$eq:"Albert"})

vote_average=5.5 and original_title="Albert"
db.getCollection('films').find({vote_average:5.5,original_title:{$eq:"Albert"}})

original_title like %the%
db.getCollection('films').find({"original_title":/.*the.*/})

original_title like %the% or credits.cast.name=Matthew McConaughey
db.getCollection('films').find({$or: [ {"original_title":/.*the.*/},{"credits.cast.name":"Matthew McConaughey"} ]})

============== Dev =============
http://rico/search/   =>liste des n dernierajouté
http://rico/search/query=Matrix => liste de tt ce qui macht avec  MAtrix
	    search/cast=Keanu Reeves
	    search/year=2001
http://rico/IDXX  => detail du film

=======
