package mrs.domain.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {

    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<ReservableRoom> findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);

}
