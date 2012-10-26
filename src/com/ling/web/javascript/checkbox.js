<script type="text/javascript">
    $(document).ready(function(){
        $("th").find(":checkbox").click( function() { 
            if ($(this).attr('checked') ) {
                $(this).parents("table").find("td").find(":checkbox").attr("checked", true);
            } else {
                $(this).parents("table").find("td").find(":checkbox").attr("checked", false);
            }       
        });

        $("td").find(":checkbox").click( function() { 
            var par = $(this).parents("table").find("th").find(":checkbox");
            if(! $(this).attr('checked') ) {
                par.attr('checked',false);
            } else if( $(this).parents("table").find("td").find(":checkbox:not(:checked)").size() == 0) {
                par.attr('checked',true);
            }
        });
    });
</script>
