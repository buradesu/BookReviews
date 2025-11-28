function getBook(id){
    fetch("http://localhost:8080/books/"+id)
        .then(data => data.json())
        .then(function(data){ showBook(data);})
    fetch("http://localhost:8080/reviews/search/findByBookId?id="+id)
        .then(data => data.json())
        .then(function(data){ showReviews(data);})
}
function showBook(bookdata){
    var bookDetails =
        "<br>Title: " +bookdata.title +
        "<br>Authors: " +bookdata.authors;
            document.getElementById("bookdetails").innerHTML=bookDetails;
}
function showReviews(data){
    if (!data._embedded || !data._embedded.reviews) {
        document.getElementById("reviewdetails").innerHTML = "<p>No reviews yet.</p>";
        return;
    }
    var reviewsList = data._embedded.reviews;
    var reviewsDetails = "<ul>";
    reviewsList.forEach((review) => {
        reviewsDetails += "<li>" + review.reviewText + "</li>";
    });
    reviewsDetails += "</ul>"; // Don't forget to close the tag!
    document.getElementById("reviewdetails").innerHTML = reviewsDetails;
}