package leetcode;

import java.util.HashSet;

public class LongestDuplicateSubstring
{
	public static void main(String[] args)
	{
		LongestDuplicateSubstring l = new LongestDuplicateSubstring();
		System.out.println(l.longestDupSubstring("banana"));
		System.out.println(l.longestDupSubstring(
			"shabhlesyffuflsdxvvvoiqfjacpacgoucvrlshauspzdrmdfsvzinwdfmwrapbzuyrlvulpalqltqshaskpsoiispneszlcgzvygeltuctslqtzeyrkfeyohutbpufxigoeagvrfgkpefythszpzpxjwgklrdbypyarepdeskotoolwnmeibkqpiuvktejvbejgjptzfjpfbjgkorvgzipnjazzvpsjxjscekiqlcqeawsdydpsuqewszlpkgkrtlwxgozdqvyynlcxgnskjjmdhabqxbnnbflsscammppnlwyzycidzbhllvfvheujhnxrfujwmhwiamqplygaujruuptfdjmdqdndyzrmowhctnvxryxtvzzecmeqdfppsjczqtyxlvqwafjozrtnbvshvxshpetqijlzwgevdpwdkycmpsehxtwzxcpzwyxmpawwrddvcbgbgyrldmbeignsotjhgajqhgrttwjesrzxhvtetifyxwiyydzxdqvokkvfbrfihslgmvqrvvqfptdqhqnzujeiilfyxuehhvwamdkkvfllvdjsldijzkjvloojspdbnslxunkujnfbacgcuaiohdytbnqlqmhavajcldohdiirxfahbrgmqerkcrbqidstemvngasvxzdjjqkwixdlkkrewaszqnyiulnwaxfdbyianmcaaoxiyrshxumtggkcrydngowfjijxqczvnvpkiijksvridusfeasawkndjpsxwxaoiydusqwkaqrjgkkzhkpvlbuqbzvpewzodmxkzetnlttdypdxrqgcpmqcsgohyrsrlqctgxzlummuobadnpbxjndtofuihfjedkzakhvixkejjxffbktghzudqmarvmhmthjhqbxwnoexqrovxolfkxdizsdslenejkypyzteigpzjpzkdqfkqtsbbpnlmcjcveartpmmzwtpumbwhcgihjkdjdwlfhfopibwjjsikyqawyvnbfbfaikycrawcbkdhnbwnhyxnddxxctwlywjcisgqfsctzatdgqqauuvgclicdrpjcphysqdjaflpdbmvnhqggixxzcmpsysbwfkzwxzjictnngufpqhcxlbkodyrqlfomlkiefbmcfenugzqnyqqvgpxonmizkpjdlaqyyowjagzkzrzvcrupfyofeftyfvoqorzvxphhdhydnqiyiczfcgzsecxzsoaobwrixcajabjnvtoerzwayjowahrmuixmmkbtchogfizmvbjnpespxngxjxntohzatlpkcmpphmewevpteharnszafbpbexrvnbedieojezdhnyooiivhnhakilvkobxepbksnqrtxxuqhalvtjspyvporalbliiwjciamlhttaydhxoelimuorjnfvebjhcocbkrgbguwdncodskzzoqrzgavsbjcippetltqaxjhkqacwlgmsbxezqubyzeznnsoqegkykzlxohvitbmjcxllbrvgdijyovpjyeaojlyxqwnheyblznwoyikhqiutotpfukyqkvatxotulvlqzfcvskdccuixthzqrwymzccosjmjqjigehcnfphjuuybaxxukconatzseljyirycbhucxmwwftulfwfmyqyprlnsmxzyfmgjctgeunuuexhbrbsaaingqxqrjvpuhbvcmyztmkgenhonajrkzfrqjinjrbmjyinhwvlcmmxvbgvjgfmaoliosmxbonvlzoiqvkxxtoposygcgkcotohcrauivxxvmrghuauadwojxjligrgstczirnvhqpzwgjbvqzlkxltqnqrfxieggnuriytavbnouwhuamdtlspednyckixkhxedjmotiuucewllthhducwgwmgzxsbkqzfnqfynwisvsctyqdoaiypjivtxkxgoyhwhccklbdjoqykaqzljejlizgbehekmkfetvgfstmypmfnyoundudqlorcogbzoznddfalthwpmiewkmvogmzirbprjftbtffjrkrfminnechitfyfaujgtugadqbrskulsjbaunonxolauvsifevpdyurvfocxtkizflcuvltzuhwyhlbxaphifhtgkfktfnnmocpenrlujsuppbbuorvtubuiyszawzftijwhwgdyubjmmodzybiyunksuixnkariubegpdgctbayaynfskkuyhjvegsjwsbppodvhpjdjlzhxixswdncapxyfjspxeqxdfkhockvrzoisikaymoiqzqbjyoscwegfomlnurwboesfiszetebjblaolnovgvfcpnbemwambkhwcgdbhvkoluhjfxlfrfaeedocdilaboesauplmttewlbojkocklhsbzrtzeyhqtmgroupbzlymupmupsvlkzchclujuozzmngjvktzstsvocxrziuxelruwojzaleyrkjkdleavwqxwgjdbtiywqtdtaamrlcjogxufhgvoqpqkgopbtyqchzhexqgecheahjzxapqjdylzjqhzlzssbjmokncxalgasexztnlzfisxxpeerywlrjdohprewwnlwdbtwmfnnxnoolfhqqxzcvoymdbvmaoliedpvwzyvgyrwjguvoqnxrnaeqwvcfrqkwjmlvxovptultyfuxerelpfgctnpdxluqeruxkxqntosggfjqmrnlnkhhilznpycdrnemnktcsmzufpqgiraphzmgfhevzejhavsypohpttnnowfahpxfwmvxgwfuomxemdkzdlzldesmowzmhwoydnsovwykxqyllbmcurlvtwcfwxvvkxfknwwcwfjkzjtonalgijdsulcfagehiptszrcltbbypopdbmdfkyofelmrdmdbceguyxnkheqqtbletpqmjugpckmjyuuvsbqhyzmposwcgscnishluuhnwkyrkujefpgtsqrmcoortgitpdoagdncxlofkqozgngbtmlyyoyodcmcwetdtltupjrtemrjswekkfjvfecmvagyptjjuwsqpjwlxxosqhpssdvjraaicjfwvesyqfbumjjbqytkinpldxopxjzmvpigmberobyzyxwvwmlmbziduqhmbescgkvhgqtalmaxfsjlysmvrizgvrudstiwmaahtqehfbofvqwgqygvseykmgmhgjbxcrtdjqvojvyhohallyewqelzhjeuqmmsqhkluvqsfmxzbqqokehfoqrlqmwpnwojfowqpqebnuggeuvsszgfywceolvabyvbrwatuyherijsdqvpyyhdyradbammmchqkvdbxpbrxzrpfrsiiezvowrfqejibvociujtcwbygvfwojgfnvvwqlqqgipxhrogppzghtnweodaxuqxknnqnajlnsvheiycsvifvoljsncgnunsqcymnyoeeslrjflpprvtksimffvnuvakskdakvmlkpowfpfzdrcfctikhvvbagrvjlzjydnlmspzyynyjjfxnozpjjgjelipswsmfroitqphzsuqgumlnkxksbzhrsvcnfwufofhurmhksvvfjzggbtgrezkrkqmhduyqgwuwxoxaiifemtwrbilftiuhcgpjvqxldrnlzphdffncevlcyrxlpbwuswjfdegexeoooshdfqtqithpfocyowaqeedikssptyvkabhtaeotcwxccgguuotqvypugpcbwzalxwqbjdcokoxjnqhggpbbfeyjiellsikiqqtxpvzmjsfleepjpbxpeicxfcwbpprzgcrjgjaxshewradetsqsvfmcxptmksecfpynqzpctqpogcgokzrkltsbmwxkmynasohpkzjupapngusnvdjfqezqhyikllgkelewwwhhbdjvxdagnnxscjkotbbmhzkqbjwuwidrnvmztikmqjcxmcpgkoudhydmdvberfuvjnhlnfcsbpzmuquvrgogtfwefhqzkmxxgadtvjpxvurxprbsssihviypclwkjfaatzjxtvlzwaacqlwnqetgkldqaqghuihrgxbbpmjfsvaigqrhiiskkfibaeilqptkdsqqfwxeixuxgkiboaqnuaeutjcydnxyxnmattjrrxmthwvyipgazaxgrrjcvdnyxpktsldhluhicyqprxhljyfhawuvoonrwyklcdlmdvsgqrwqqomisksftsfyeifmupvylkjbagzyctuifbsrugqsbrkvskmundmczltpamhmgqespzgrkxebsvubrlmkwyqhjyljnkeqvdxtjxjvzlrubsiiahciwefwsswgssxmvyvgjrobvubcbgjomqajmotbcgqjudneovfbjtjzwqtsovzshmxeqofssukkvcdwlsdtyplrlgwtehnwvhhegtwkwnqqdiajpcaajsylesadaiflruewhrbrogbujbppunsqgytgnyuhnkejhccavaptbydtqhvyatftxcaaljyhhkkadzdhhzawgndunwwgknnbtqaddpszqgummmnomfqmdxqtwjexsbadfdqhnyixjslsaisscocbabivzokkgiinqqzsrtfpzjmxfkqmuzzlelqjtjidjarkwbwlcqrefokrlwdmuzyffdtajnqoimlzzpcgpjjwlqkusefzbgznhexzojxnzxmmedobgvdabtdoiskozrdrjscxwivaekrkyyfynuktmgyziteavdxfctvkfkrmsdwpaywzbkeojeycwdkectydojttisizruilwokhepscqdnjygiakomkhyujaffxjyxqmvkemqihpcdygprdeaxgjbkonfvgtzayfbmgwsskoyxjlknwwtehhhpjllhkcblyaxnbekoidbbyqvdqqsyfcemylmqskpxifcnhmemkkitqtbfwhmyemkzightkjbhlquticivpeeclpamsqoztxvdtcqbsonxyecnhcadtghkjckhrcdfggnqlwurydzbeybqkcfnnbwkciwaqdzgmcrbltvcuftxsqfpxnoombsbeoqxivgtkrjklxatgcorkdrvmngwlekeopgecefzxtprcoajoopxviijxilxfiwuajsbtcctfcqqgzhyjmonwdbyjlnneidyaqhhothzpzaxcthvbxpdcqofaeamxbqjwhunnqwclhcqhagawjsxygorgbuqryzickyplbaivkabbrkibqzqacabbwmnpndaqvbknbqcjuywxjrdbznndomwbbqfgulwczydrhrocebhygriiwxmwtjjyqqiqrjblxuamddlsiocdoysdaacuovljtpgocephnxuugdyggsnhcqiqhulyhlxiwzvhrtbmvjnhacwunckqzhpcthqgsupptdwkfeprbg"));
	}

	public final static int d = 26;
	public final static long mod = (long) Math.pow(2, 32);

	public String longestDupSubstring(String S)
	{
		int[] arr = new int[S.length()];
		for (int i = 0; i < S.length(); i++)
		{
			char c = S.charAt(i);
			arr[i] = c - 'a';
		}
		int left = 1, right = S.length();
		int mid;
		while (left != right)
		{
			mid = left + (right - left) / 2;
			if (search(mid, S.length(), arr) != -1)
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}

		int start = search(left - 1, S.length(), arr);
		return start != -1 ? S.substring(start, start + left - 1) : "";
	}

	static int search(int left, int n, int[] nums)
	{
		long hash = 0;
		for (int i = 0; i < left; ++i)
		{
			hash = (hash * d + nums[i]) % mod;
		}

		HashSet<Long> seen = new HashSet();
		seen.add(hash);
		long aL = 1;
		for (int i = 1; i <= left; ++i)
		{
			aL = (aL * d) % mod;
		}

		for (int start = 1; start < n - left + 1; ++start)
		{
			hash = (hash * d - nums[start - 1] * aL % mod + mod) % mod;
			hash = (hash + nums[start + left - 1]) % mod;
			if (seen.contains(hash))
			{
				return start;
			}
			seen.add(hash);
		}
		return -1;
	}
}
