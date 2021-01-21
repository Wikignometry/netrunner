(ns nr.translations
  (:require
    [nr.appstate :refer [app-state]]
    [taoensso.tempura :as tempura]))

(def translation-dictionary
  {
   :en 
   {:missing ":en missing text"
    :chat
    {:title "Play Android: Netrunner in your browser"
     :channels "Channels"
     :send "Send"
     :placeholder "Say something..."}
    :nav
    {:chat "Chat"
     :cards "Cards"
     :deck-builder "Deck Builder"
     :play "Play"
     :help "Help"
     :settings "Settings"
     :stats "Stats"
     :about "About"
     :tournaments "Tournaments"
     :admin "Admin"
     :users "Users"
     :game-count (fn [[cnt]] (str cnt " Game" (when (not= cnt 1) "s")))}
    :menu
    {:settings :en.nav/settings
     :logout "Jack out"
     :admin :en.nav/admin
     :moderator "Moderator"}
    :card-browser
    {:search-hint "Search cards"
     :sort "Sort by"
     :format "Format"
     :set "Set"
     :side "Side"
     :faction "Faction"
     :type "Type"
     :clear "Clear"
     :select-art "Select Art"
     :update-success "Updated Art"
     :update-failure "Failed to Update Art"
     }
    }
   
   :la-pig
   {:missing ":la-pig missing text"
    :chat
    {:title "Ayplay Android: Etrunnernay inyay ouryay owserbray"
     :channels "Annelschay"
     :send "Endsay"
     :placeholder "Aysay omethingsay..."}
    :nav
    {:chat "Atchay"
     :cards "Ardscay"
     :deck-builder "Eckday Uilderbay"
     :play "Ayplay"
     :help "Elphay"
     :settings "Ettingssay"
     :stats "Atsstay"
     :about "Aboutyay"
     :tournaments "Ournamentstay"
     :admin "Adminyay"
     :users "Usersyay"
     :game-count (fn [[cnt]] (str cnt (if (= 1 cnt) " Amegay" " Amesgay")))
     }
    :menu
    {:settings :la-pig.nav/settings
     :logout "Ackjay outyay"
     :admin :la-pig.nav/admin
     :moderator "Oderatormay"}
    :card-browser
    {:search-hint "Earchsay ardscay"
     :sort "Ortsay ybay"
     :format "Ormatfay"
     :set "Etsay"
     :side "Idesay"
     :faction "Actionfay"
     :type "Etypay"
     :clear "Earclay"
     :select-art "Electsay Artyay"
     :update-success "Updatedyay Artyay"
     :update-failure "Ailedfay otay Updateyay Artyay"
     }
   }})

(def opts {:dict translation-dictionary})
(defn tr [resource & params]
  (let [lang (keyword (get-in @app-state [:options :language] "en"))]
    (tempura/tr opts [lang :en] resource (vec params))))
