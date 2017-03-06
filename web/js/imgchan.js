  $(document).ready(function() {

      (function() {
          var readFilePath;
          readFilePath = function(input) {
              var fileReader;
              if (input.files && input.files[0]) {
                  fileReader = new FileReader();
                  fileReader.onload = function(e) {
                      return $('.image-preview').attr('src', e.target.result);

                  };
                  $('.image-preview').removeClass('hidden');
                  return fileReader.readAsDataURL(input.files[0]);
              }

          };
          $('.image-upload').change(function() {
              return readFilePath(this);
          });
      }.call(this));

  });