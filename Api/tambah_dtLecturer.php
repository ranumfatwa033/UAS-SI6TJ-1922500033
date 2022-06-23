
<?php

require_once 'koneksi.php' ;

        $nidn = $_POST['nidn'];
        $NmDosen = $_POST['nama_dosen'];
        $Jabatan = $_POST['jabatan'];
        $gol = $_POST['gol_pang'];
        $Keahlian = $_POST['keahlian'];
        $prodi = $_POST['program_studi'];
        $sql = mysqli_query($con, "insert into lecturer(nidn,nama_dosen,jabatan,gol_pang,keahlian,program_studi) values ('$nidn','$NmDosen','$Jabatan','$gol','$Keahlian','$prodi')");
    if($sql){
        echo json_encode($sql);
    }
?>
