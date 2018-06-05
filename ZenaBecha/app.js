var express = require("express");
var fs = require("fs");
var app = express();
var router = express.Router();
app.use(express.static("public"));

router.route('/getDomesticNews')
    .get(function(req,res,next){
        console.log(fs.readFileSync("./domesticNews.json").toString());
        res.send(fs.readFileSync("./domesticNews.json").toString()).status(200);
    });

router.route('/getForeignNews')
    .get(function(req, res, next){
        console.log(fs.readFileSync("./foreignNews.json").toString());
        res.send(fs.readFileSync("./foreignNews.json").toString()).status(200);
    });
app.use('/', router);
app.listen(4000);
console.log("listening 4000 ...");