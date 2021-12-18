package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.PairMatchingView;

public class Manager {
	private List<MatchInfo> matchInfos = new ArrayList<>();
	private List<MatchInfo> sameLevelList = new ArrayList<>();

	public boolean setDetail(String[] selections) {
		MatchInfo matchInfo = new MatchInfo(selections);
		notDuplicationMatching(matchInfo);
		matchInfos.add(matchInfo);
		return true;
	}

	public boolean isDuplication(String[] selections) {
		for (MatchInfo matchInfo : matchInfos) {
			if (matchInfo.isSameThing(selections[0], selections[1], selections[2])) {
				return true;
			}
		}
		return false;
	}

	public void notDuplicationMatching(MatchInfo matchInfo) {
		for (MatchInfo info : matchInfos) {
			if (info.isSameLevel(matchInfo)) {
				sameLevelList.add(info);
			}
		}
		matchInfo.match(sameLevelList);
	}

	public MatchInfo find(String[] selections) {
		MatchInfo result = null;
		for (MatchInfo matchInfo : matchInfos) {
			result = matchInfo.search(selections[0], selections[1], selections[2]);
		}
		return result;
	}

	public void resetAllPair() {
		for (MatchInfo matchInfo : matchInfos) {
			matchInfo.resetPair();
		}
	}

}
