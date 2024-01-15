const BsCarousel = function () {
    // Carousel interval
    // $('.carousel').carousel({
    //     interval: 1000
    // });

    // smart height detection for all major screens
    // if (Layout.getViewPort().width > 1600) {
    //     height = $(window).height() - $('.subscribe').outerHeight();  // full height for high resolution
    // } else if (Layout.getViewPort().height > height) {
    //     height = Layout.getViewPort().height;
    // }

    (function ($) {
        //Function to animate slider captions
        function doAnimations(elems) {
            //Cache the animationend event in a variable
            const animEndEv = 'webkitAnimationEnd animationend';

            elems.each(function () {
                const $this = $(this),
                    $animationType = $this.data('animation');
                $this.addClass($animationType).one(animEndEv, function () {
                    $this.removeClass($animationType);
                });
            });
        }

        //Variables on page load
        const $myCarousel = $('#carousel-example-generic'),
            $firstAnimatingElems = $myCarousel.find('.item:first').find("[data-animation ^= 'animated']");

        //Initialize carousel
        $myCarousel.carousel();

        //Animate captions in first slide on page load
        doAnimations($firstAnimatingElems);

        //Pause carousel
        $myCarousel.carousel('pause');

        //Other slides to be animated on carousel slide event
        $myCarousel.on('slide.bs.carousel', function (e) {
            const $animatingElems = $(e.relatedTarget).find("[data-animation ^= 'animated']");
            doAnimations($animatingElems);
        });

    })(jQuery);
}();