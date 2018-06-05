var express = require("express");
var fs = require("fs");
var app = express();
var router = express.Router();
var port = 5000;

var domesticNewsFilename = "./domesticNews.json";
var foreignNewsFilename = "./foreignNews.json";

app.use(express.static("admin"));
app.use(express.json(
    {extended:true}
));
app.use(express.urlencoded(
    {extended:true}
));

router.route('/addContent')
    .get(function(req,res,next){
        var title = req.query.title;
        var summary = req.query.summary;
        var type = req.query.type;
        console.log(title);
        console.log(summary);
        console.log(type);
        if(type == "domestic"){
            // console.log("Domestic");
            let present = false;
            var domesticNews = JSON.parse(fs.readFileSync(domesticNewsFilename).toString());
            for(let i = 0; i < domesticNews.length; i++){
                if(domesticNews[i].title == title){
                    present = true;
                }
            }
            if(present){
                res.send("").status(200);
            }else{
                domesticNews.push({"title":title,"summary":summary});
                fs.writeFileSync(domesticNewsFilename,JSON.stringify(domesticNews));
                res.send("Success").status(200);                
            }
        }else if(type == "foreign"){
            let present = false;
            var foreignNews = JSON.parse(fs.readFileSync("./foreignNews.json").toString());
            for(let i = 0; i < foreignNews.length; i++){
                if(foreignNews[i].title == title){
                    present = true;
                }
            }
            if(present){
                res.send("").status(200);
            }else{
                foreignNews.push({"title":title,"summary":summary});
                fs.writeFileSync(foreignNewsFilename,JSON.stringify(foreignNews));
                res.send("Success").status(200);
            }

        }else {
            res.send("failure").status(404);
        }   
    });
router.route('/addDomesticContent')
    .post(function(req, res, next){
        var title = req.body.title;
        var summary = req.body.summary;
        
    });
router.route('/addForeignContent')
    .post(function(req,res,next){
        var title = req.body.title;
        var summary = req.body.summary;
        console.log(fs.readFileSync("./foreignNews.json").toJSON());
    });
app.use('/', router);
app.listen(port);
console.log("Listening "+port+"...");